class App {
    static iziToast = class {
        static showSuccessAlert(t) {

            iziToast.success({
                title: 'OK',
                position: 'topRight',
                timeout: 2100,
                message: t
            });
        }

        static showErrorAlert(t) {
            iziToast.error({
                title: 'Error',
                position: 'topRight',
                background: "yellow",
                timeout: 1700,
                message: t
            });
        }
    }
}


class User {
    constructor(id, fullName, roleId, phone, email, address, status, avatarUrl, username) {
        this.id = id;
        this.fullName = fullName;
        this.roleId = roleId;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.avatarUrl = avatarUrl;
        this.username = username;

    }
}

class Order {
    constructor(id, grandTotal, userId, orderType, orderStatus, address, createdAt, fullName, phone) {
        this.id = id;
        this.fullName = fullName;
        this.grandTotal = grandTotal;
        this.phone = phone;
        this.orderStatus = orderStatus;
        this.address = address;
        this.orderType = orderType;
        this.createdAt = createdAt;
        this.userId = userId;

    }
}