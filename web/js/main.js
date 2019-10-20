function checkPass() {
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    if (pass1.value === pass2.value) {
        pass2.style.backgroundColor = goodColor;
    } else {
        pass2.style.backgroundColor = badColor;
    }
}

function makeEditable() {
    var inputs = document.querySelectorAll("input[type=text]");
    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        var dis = input.getAttribute("disabled");
        input.disabled = false;
    }
    var saveButton = document.getElementById("save");
    saveButton.hidden = false;

    var cancelButton = document.getElementById("cancel");
    cancelButton.hidden = false;

    var editButton = document.getElementById("edit");
    editButton.hidden = true;
}

function disableRoleDropdown() {
    var roleSelect = document.getElementById("role");
    roleSelect.disabled = true;
}