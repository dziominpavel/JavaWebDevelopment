function checkAge() {

    var val = document.getElementById('textinputAge').value;
    var len = val.toString().length;
    var valInt = parseInt(val);
    if (len != 0) {
        if (valInt > 100 || valInt < 1 || isNaN(valInt)) {
            window.alert("Введите корректный возраст");
        }
    }


}