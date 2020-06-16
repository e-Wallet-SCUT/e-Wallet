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
            this.disable = true
        }
    },
    mounted(){
        this.getUserInfo()
    },
    template:"#userInfoTem"
})
Vue.component('two',{
    template:'<h1>2</h1>'
})
new Vue({
    el:"#app",
    data:{
        comName:""
    }
})
// new Vue({ el: '#components' })
