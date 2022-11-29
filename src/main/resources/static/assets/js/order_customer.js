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
        let li = `<li id="${country.id}" onclick="updateName(this)" class="${isSelected} selectCustomers">${country.fullName}</li>`;
        options1.insertAdjacentHTML("beforeend", li);
    });
}
addCustomer();

function updateName(selectedLi) {
  let id = $(selectedLi).attr('id')
    getUserById(id).then((userId)=>{

        $("#nameCus").val(userId.fullName);
        $("#nameCus").attr("disabled", "disabled");
        $("#addressCus").val(userId.address);
        $("#addressCus").attr("disabled", "disabled");
        $("#phoneCus").val(userId.phone);
        $("#phoneCus").attr("disabled", "disabled");
    })
     searchInp.value = "";
    addCustomer(selectedLi.innerText);
    wrapper.classList.remove("active");
    selectBtn.firstElementChild.innerText = selectedLi.innerText;
    $("#idCustomerCre").val(selectedLi.id);
}

function getUserById(userId) {
    return (
        $.ajax({
            headers: {
                "Accept": 'application/json',
                "Content-type": 'application'
            },
            type: "GET",
            url: "http://localhost:8080/api/users/" + userId,
        }).done((data) => {
        }).fail((jxHQR) => {
            console.log(jxHQR)
        })
    )
}


selectBtn.addEventListener("click", () => {
    let arr = [];
    arr = customers.map(data => {
        let isSelected = data == selectBtn.firstElementChild.innerText ? "selected" : "";
        return `<li id="${data.id}" onclick="updateName(this)" class="${isSelected} selectCustomers">${data.fullName}</li>`;
    }).join("");
    options1.innerHTML = arr ? arr : `<p style="margin-top: 10px;">Không tìm thấy khách hàng!</p>`;
});

selectBtn.addEventListener("click", () => wrapper.classList.toggle("active"));