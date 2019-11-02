function validate(){
    var listNum=$("#listNum").value();
    var regex=/(-?\d+,){9}(-?\d+)/;
    var numOfNumber=listNum.split(",");
    if(!regex.test(listNum)||numOfNumber.length!=10){
        alert("please enter 10 number split by ','");
        return false;
    }else {
        return true;
    }
}