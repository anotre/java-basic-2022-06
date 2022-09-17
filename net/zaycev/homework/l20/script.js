'use strict'

let form = document.getElementById("form");
let table = document.getElementById("table");
let tableBody = document.getElementById("table-body");
let formFields = ["student-name", "student-birthday", "student-sex", "student-age"];

form.addEventListener("submit", function(e) {
    e.preventDefault();
    let formData = getFormData(form);
    let tableRow = createTableRow(formFields, tableBody);

    fillTableRow(formFields, formData, tableRow);
    updateResults(table);

});

function createTableRow(columns, tableBody) {
    let tableRow;
    let cell;
    let rowsLength = tableBody.children.length;
    tableRow = (rowsLength > 1) ? tableBody.insertRow(rowsLength - 2) : tableBody.insertRow();

    for (let columnName of columns) {
        cell = tableRow.insertCell();
        cell.classList.add(columnName);
    }

    return tableRow;
}

function getFormData(form) {
    let formDataSrc = new FormData(form);
    let formData = {};

    for (let [key, value] of formDataSrc.entries()) {
        formData[key] = (key === "student-birthday") ? getFormattedDate(value) : value; 
    }

    return formData;
}

function fillTableRow(fieldsOrder, data, destRow) {
    let children = destRow.children;

    for (let i = 0; i < fieldsOrder.length; i++) {
        children[i].innerHTML = data[fieldsOrder[i]];
    }
}

function updateResults(table) {
    let rows = table.tBodies[table.tBodies.length - 1].children;
    let rowsLength = rows.length;
    
    if (rowsLength === 1) {
        insertResultsTemplate(table);
    }
    
    let sum = 0;
    let bufferList = table.querySelectorAll(".student-age");

    for (let cell of bufferList) {
        sum += parseInt(cell.innerHTML);
    }
    table.querySelector(".avarage-age").innerHTML = sum / bufferList.length;
}

function insertResultsTemplate(table) {
    let gapRow = table.insertRow().insertCell();
    gapRow.setAttribute("colspan", table.tHead.children[0].children.length);
    gapRow.innerHTML = "&nbsp;";
    
    let resultRow = table.insertRow();
    let titleCell = resultRow.insertCell();
    let avarageAgeCell = resultRow.insertCell();
    
    titleCell.setAttribute("colspan", "3");
    titleCell.innerHTML = "Средний возраст студентов:";
    avarageAgeCell.classList.add("avarage-age");
}

function getFormattedDate(date) {
    let bufferDate = new Date(date);
    let day = forwardZeroInDate(bufferDate.getDate());
    let month = forwardZeroInDate(bufferDate.getMonth());

    return `${day}-${month}-${bufferDate.getFullYear()}`;
}

function forwardZeroInDate(datePart) {
    return (String(datePart).length === 1) ? `0${datePart}` : String(datePart);
} 
