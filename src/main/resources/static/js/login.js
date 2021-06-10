var vm = new Vue({
    el:"#loginCon",
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
            axios.get('/shoppingmall/login/judge',{
                params:{
                    user_name:that.user_name,
                    user_password: that.user_password
                }
            }).then(function (response) {
                if(response.data===1){
                    sessionStorage.setItem("user_name",that.user_name);
                    window.location.href='/shoppingmall/index.html';
                }else{
                    alert("用户名或密码错误");
                    that.user_name="";
                    that.user_password="";
                }

            })


        }
    },
    created:function () {
        if (sessionStorage.getItem("user_id")!==null) {
            sessionStorage.removeItem("user_id");
        }
    }


});