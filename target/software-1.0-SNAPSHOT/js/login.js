function toLogin(){
    var name=document.getElementById("name").value;
    var password=document.getElementById("password").value;
    if(name==""){
        alert("用户名不能为空");
        return false;
    }
    if(password==""){
        alert("密码不能为空");
        return false;
    }
    return true;
}
