let wrapper = document.querySelector(".wrapper1");
let selectBtn = wrapper.querySelector(".select-btn");
let searchInp = wrapper.querySelector("input");
let options1 = wrapper.querySelector(".options1");


let customers = [];


$.ajax({
    url: 'http://localhost:8080/api/users/getUserByRoleId/2',
    method: "GET",
    success: function (posts) {
        customers = posts;
    }
})



function addCustomer(selectedCountry) {
    options1.innerHTML = "";
    customers.forEach(country => {
        let isSelected = country == selectedCountry ? "selected" : "";
        let li = `<li id="${country.id}" onclick="updateName(this)" class="${isSelected}">${country.fullName}</li>`;
        options1.insertAdjacentHTML("beforeend", li);
    });
}
addCustomer();

function updateName(selectedLi) {
    searchInp.value = "";
    addCustomer(selectedLi.innerText);
    wrapper.classList.remove("active");
    selectBtn.firstElementChild.innerText = selectedLi.innerText;

    $("#idCustomerCre").val(selectedLi.id);
}



searchInp.addEventListener("keyup", () => {
    let arr = [];
    let searchWord = searchInp.value.toLowerCase();
    arr = customers.filter(data => {
        return data.fullName.toLowerCase().startsWith(searchWord);
    }).map(data => {
        let isSelected = data == selectBtn.firstElementChild.innerText ? "selected" : "";
        return `<li id="${data.id}" onclick="updateName(this)" class="${isSelected}">${data.fullName}</li>`;
    }).join("");

    // `<li id="user_${item.id}" onclick="onclickUser(${item.id})">${user.fullName} - ${user.phone}</li>`;
    options1.innerHTML = arr ? arr : `<p style="margin-top: 10px;">Oops! Customer not found</p>`;
});

selectBtn.addEventListener("click", () => wrapper.classList.toggle("active"));