var vm = new Vue({
    el:"#header",
    data:{
        user_name:"",
        type:"请登录",
        type1:"免费注册",
        user_name_css:"margin-top: 5px;margin-right:30px;font-size: 10px;display:none;"
    },

    created:function () {
        var that = this;
        if (sessionStorage.getItem("user_name")!==null)
        {
            that.user_name_css="margin-top: 5px; margin-right: 30px; font-size: 10px;color: #999;";
            that.type="退出";
            var user_id = sessionStorage.getItem("user_name");
            axios.get('http://localhost:8080/shoppingmall/index/user',{
                params:{
                    user_id:user_id
                }
            })
                .then(function (response) {
                    that.user_name=response.data.user_name;
                }).catch(function (error) {
                alert(error);
            })
        }
    }



});