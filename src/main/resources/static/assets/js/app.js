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
    constructor(id, fullName, roleId, phone, email, address, status, avatarUrl, username,
                createdBy, createdAt, totalOrder) {
        this.id = id;
        this.fullName = fullName;
        this.roleId = roleId;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.avatarUrl = avatarUrl;
        this.username = username;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.totalOrder = totalOrder;
    }
}




class Order {
    constructor(id, grandTotal, userId, user, orderStatus, orderType, address, createdBy, createdAt, fullName, phone) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.userId = userId
        this.user = user
        this.orderStatus = orderStatus
        this.orderType = orderType
        this.address = address
        this.createdAt = createdAt
        this.createdBy = createdBy
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
    constructor(id, productId, product, userId, user, orderId, price, quantity, sold, available, defective, createdAt, createdBy, updatedAt, updatedBy) {
        this.id = id;
        this.productId = productId;
        this.product = product
        this.userId = userId;
        this.user = user
        this.orderId = orderId;
        this.sold = sold ;
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

class Product {
    constructor(id, title, price, quantity, funds) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.funds = funds;
    }
}