document.addEventListener("DOMContentLoaded", function () {
    const addInfoLink = document.querySelector(".add-info-link");
    const addInfoSection = document.querySelector(".add_info");

    addInfoLink.addEventListener("click", function () {
        addInfoSection.style.display = "block";
    });

    const signUpForm = document.getElementById("signup-form");

    signUpForm.addEventListener("submit", function (event) {
        const password = document.getElementById("password").value;
        const rePassword = document.getElementById("re_password").value;

        if (password !== rePassword) {
            event.preventDefault();
            const errorMessage = document.createElement("div");
            errorMessage.className = "error-message";
            errorMessage.innerText = "Passwords do not match.";
            signUpForm.appendChild(errorMessage);
        }
    });
});
