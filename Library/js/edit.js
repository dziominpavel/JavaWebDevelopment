function checkAge() {
    var age = parseInt(document.getElementById('textinputAge').value);
    if (age > 100 || age < 1 || isNaN(age)) {
        window.alert("Введите корректный возраст");
    }
}