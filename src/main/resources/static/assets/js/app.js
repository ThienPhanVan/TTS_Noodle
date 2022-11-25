class App {

    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

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
    };

    static sweetAlert = class {
        static showDelete() {
            return Swal.fire({
                title: 'Lưu Ý !',
                text: "Bạn Có Chắc Muốn Xóa Đơn Hàng Này ?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'

            })
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
    constructor(id, grandTotal, product, userId, user, orderStatus, orderType, address, createdBy, createdAt, fullName, phone, orderItem, paid) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.userId = userId;
        this.user = user;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.address = address;
        this.product = product;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.fullName = fullName;
        this.phone = phone;
        this.orderItem = orderItem;
        this.paid = paid;
    }
}

class OrderPayment {
    constructor(id, orderItem, createdAt, paid) {
        this.id = id;
        this.orderItem = orderItem;
        this.createdAt = createdAt;
        this.paid = paid;
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
    constructor(id, productId, product, userId, user, orderId, price, quantity, sold, available, defective, createdAt, createdBy, updatedAt, updatedBy) {
        this.id = id;
        this.productId = productId;
        this.product = product
        this.userId = userId;
        this.user = user
        this.orderId = orderId;
        this.sold = sold;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
        this.defective = defective;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;

    }
}

class PaymentPurchase{
    constructor(id, userId, user, orderId, order, paid, createdAt) {
        this.id = id;
        this.userId = userId;
        this.user = user;
        this.orderId = orderId;
        this.order = order;
        this.paid = paid;
        this.createdAt = createdAt;
    }
}

class Product {
    constructor(id, title, price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}

class Role {
    constructor(id, code, name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
<<<<<<< HEAD
=======

}

class PaymentCustomer {
    constructor(id, createdAt, userId, orderId, paid) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.orderId = orderId;
        this.paid = paid;
    }
>>>>>>> thien_dev
}