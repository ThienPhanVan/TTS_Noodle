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
<<<<<<< HEAD
class Order {
    constructor(id ,grandTotal , userId, user, orderStatus, orderType, address, createdBy, createdAt, fullName, phone){
        this.id = id;
        this.grandTotal = grandTotal;
        this.userId = userId;
        this.user = user;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.address = address;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.fullName = fullName;
        this.phone = phone;
    }
}
class OrderItem {
    constructor(id, price, quantity, itemId, orderId, productId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.itemId = itemId;
        this.orderId = orderId;
        this.productId = productId;
    }
}
class Item {
    constructor(id, productId, userId, orderId, price, quantity, sold, available, defective, createdAt, createdBy, updatedAt, updatedBy) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
        this.defective = defective;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
=======

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

>>>>>>> thien_dev
    }
}

class Product{
    constructor(id, title, price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}