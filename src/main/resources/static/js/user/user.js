Vue.component('userInfo', {
    data: function() {
        return {
            username: "",
            name: "",
            mobile: "",
            email: "",
            address: "",
            disable: true
        }
    },
    methods: {
        getUserInfo(){
            axios.get("/getUserInfo").then(
                r=>{
                    if (r.data.msg === "success"){
                        this.username = r.data.result.username;
                        this.name = r.data.result.name;
                        this.mobile = r.data.result.mobile;
                        this.email = r.data.result.email;
                        this.address = r.data.result.address;
                        this.$emit('update:username', r.data.result.username);
                    }
                }
            )
        },
        changeBtn(){
            this.disable = false
        },
        saveBtn(){
            // this.disable = true
            // const data = {"mobile":document.getElementById("mobile").value,"email":document.getElementById("email").value,"address":document.getElementById("address").value}
            const data = new FormData()
            data.append("mobile",document.getElementById("mobile").value)
            data.append("email",document.getElementById("email").value)
            data.append("address",document.getElementById("address").value)
            axios.post("/updateUserInfo", data).then(
                r=>{
                    this.disable = true
                    this.getUserInfo()
                }
            )
        }
    },
    mounted(){
        this.getUserInfo()
    },
    template:"#userInfoTem"
})


Vue.component('cardBind',{
    template:'#cardBindTem'
})



new Vue({
    el:"#app",
    data:{
        comName:""
    }
})
