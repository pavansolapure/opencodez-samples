class Product {
    
    constructor(name,price) {
        this.prd_id=0;
        this.prd_name=name;
        this.prd_price=price;
    }

    getAddProductSQL() {
        let sql = `INSERT INTO PRODUCTS(prd_name, prd_price) \
                   VALUES('${this.prd_name}',${this.prd_price})`;
        return sql;           
    }

    static getProductByIdSQL(prd_id) {
        let sql = `SELECT * FROM PRODUCTS WHERE PRD_ID = ${prd_id}`;
        return sql;           
    }

    static deleteProductByIdSQL(prd_id) {
        let sql = `DELETE FROM PRODUCTS WHERE PRD_ID = ${prd_id}`;
        return sql;           
    }

    static getAllProductSQL() {
        let sql = `SELECT * FROM PRODUCTS`;
        return sql;           
    }    
}

export default Product;