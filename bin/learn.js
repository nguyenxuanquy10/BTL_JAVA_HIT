var getall = {}

function Validator(object) {
    var forElemen = document.getElementsByClassName(object.form)[0]
        //console.log(forElemen)(
    function getParent(element, selector) {
        while (element.selector) {
            if (element.parentElement.matches(selector)) {
                return element.parentElement;
            }
        }
    }
    if (forElemen) {
        forElemen.onsubmit = function(e) {
            e.preventDefault();
            var isFormValid = true;
            object.rules.forEach(function(element) {
                    inputelement = forElemen.querySelector(element.selector);
                    //console.log(inputelement)
                    if (inputelement) {
                        var error;
                        var parent = inputelement.parentElement.querySelector('.form-message');
                        var tt = getall[element.selector];
                        for (var i = 0; i < tt.length; i++) {
                            error = tt[i](inputelement.value);
                            if (error) break;
                        }
                        if (error) {
                            parent.innerText = error;
                            inputelement.parentElement.classList.add('invalid')
                            isFormValid = false;

                        } else {
                            parent.innerText = '';
                            inputelement.parentElement.classList.remove('invalid')
                        }
                        inputelement.oninput = function() {
                            parent.innerText = '';
                            inputelement.parentElement.classList.remove('invalid')
                        }

                    }
                })
                // console.log(inputelement)

            var ttt = forElemen.querySelectorAll('[name]');
            console.log(ttt)
            if (isFormValid == true) {
                // console.log(object.onSubmit());
                if (typeof object.onSubmit === 'function') {
                    var data = [];
                    object.rules.forEach(function(element) {
                        var inputelement = forElemen.querySelector(element.selector);
                        data.push(inputelement.value);
                    })

                    object.onSubmit({
                        data
                    })

                }
            } else {
                console.log('bug')
            }
        }
        object.rules.forEach(element => {
            if (Array.isArray(getall[element.selector])) {
                getall[element.selector].push(element.test);
            } else {
                getall[element.selector] = [element.test];
            }
            // console.log(element.selector);
            // document.getElementById('button1').onsubmit = function(e) {
            //         e.preventDefault();
            //     }
            //  console.log(element)
            var inputelement = document.querySelector(element.selector);
            if (inputelement) {
                inputelement.onblur = function() {
                    var error;
                    var parent = inputelement.parentElement.querySelector('.form-message');
                    var tt = getall[element.selector];
                    for (var i = 0; i < tt.length; i++) {
                        error = tt[i](inputelement.value);
                        if (error) break;
                    }
                    if (error) {
                        parent.innerText = error;
                        inputelement.parentElement.classList.add('invalid')

                    } else {
                        parent.innerText = '';
                        inputelement.parentElement.classList.remove('invalid')
                    }
                    inputelement.oninput = function() {
                        parent.innerText = '';
                        inputelement.parentElement.classList.remove('invalid')
                    }
                }
            }
        })
    }
}
Validator.isRequired = function(selector, message) {
    return {
        selector: selector,
        test: function(value) {
            return value.trim() ? undefined : message || 'vui long nhap lai'
        }
    }
}
Validator.isEmail = function(selector) {
    return {
        selector: selector,
        test: function(value) {
            const regex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
            return regex.test(value) ? undefined : ' vui long nhap lai';
        }
    }
}
Validator.minLength = function(selector) {
    return {
        selector: selector,
        test: function(value) {
            return value.length > 6 ? undefined : ' vui long nhap lai';
        }
    }
}
Validator.confirm = function(selector, demooke) {
    return {
        selector: selector,
        test: function(value) {
            return value == demooke() ? undefined : 'nhap sai';
        }
    }
}
Validator.submit = function(selector) {
    return {
        selector: selector,
        test: function() {
            return;
        }
    }
}