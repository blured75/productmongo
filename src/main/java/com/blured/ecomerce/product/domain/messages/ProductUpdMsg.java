package com.blured.ecomerce.product.domain.messages;

import com.blured.ecomerce.product.domain.entity.Product;

public class ProductUpdMsg {
    Product product;
    boolean isDelete = false;

    public ProductUpdMsg(Product product, boolean isDeleted) {
        this.product = product;
        this.isDelete = isDeleted;
    }

    public ProductUpdMsg() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductUpdMsg that = (ProductUpdMsg) o;

        if (isDelete != that.isDelete) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (isDelete ? 1 : 0);
        return result;
    }
}
