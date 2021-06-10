var vm = new Vue({
    el:"#registerCon",
    data:{
        user_name:"",
        user_password:""
    },
    methods:{
        InputJudge:function (){

            if (isNaN(this.user_name)||this.user_name ===""||this.user_name===null||this.user_password ===""||this.user_password===null){
                alert("你的输入有误或不完整，请重新输入！");
            }else{
                this.loginJudge();
            }
        },
        loginJudge:function (){

            var that = this;
            axios.get('/shoppingmall/register/save',{
                params:{
                    user_name:that.user_name,
                    user_password: that.user_password
                }
            }).then(function (response) {
                if (response.data===-1) {
                    alert("该账号已经被注册");
                    that.user_name = "";
                    that.user_password="";

                }
                else  {
                    sessionStorage.setItem("user_name",that.user_name);
                    alert("注册成功");
                    window.location.href='/shoppingmall/login.html';
                }
            })


        }
    }


});