function generateBill(){

let product=document.getElementById("product");

let name=product.options[product.selectedIndex].text;

let price=Number(product.value);

let quantity=Number(document.getElementById("qty").value);

let products=[];

products.push({
name:name,
price:price,
quantity:quantity
});

let subtotal=price*quantity;

let discount=subtotal*0.10;

let amount=subtotal-discount;

let gst=amount*0.18;

let total=amount+gst;

document.getElementById("pname").innerHTML=products[0].name;
document.getElementById("price").innerHTML="₹"+products[0].price;
document.getElementById("quantity").innerHTML=products[0].quantity;
document.getElementById("subtotal").innerHTML="₹"+subtotal.toFixed(2);
document.getElementById("discount").innerHTML="₹"+discount.toFixed(2);
document.getElementById("gst").innerHTML="₹"+gst.toFixed(2);
document.getElementById("total").innerHTML="₹"+total.toFixed(2);

}
