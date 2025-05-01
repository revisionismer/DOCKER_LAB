import React from 'react';

import '../App.css';

const Card = (props) => {

    let product = props.product;

    console.log(product);

    return (
        <>
            <div className='product-card'>
                {product.id} : {product.name}, {product.price}원
            </div>
        </>
    );
};

export default Card;