new Vue({
    el: "#app",
    data: {
        username: "",
        name: "",
        mobile: "",
        email: "",
        address: ""
    },
    mounted() {
        this.getUserInfo()
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
                    }
                }
            )
        }
    }
})