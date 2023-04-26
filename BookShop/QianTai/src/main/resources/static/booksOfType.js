
let booksOfTypeVue = new Vue({
  el: "#booksOfType",
  data() {
    return {
      bookTypeList:[],
      typename:sessionStorage.getItem("typeName"),
      bookTypeId: '',
      bookTypeName: '',
      currentPage: 1,
      pageSize: 2,
        maxPage: 0
    }
  },
  methods: {
    // initBooksOfTyle(){
    //     axios.postForm("/book/getBookByType",{typeId:sessionStorage.getItem("typeId")})
    //         .then((response)=>{
    //             booksOfTypeVue.bookTypeList = response.data;
    //         })
    // },
    getBooks(currentPage) {
      axios.get('/book/queryBooksByTypeId?typeId=' + this.bookTypeId + "&currentPage=" + currentPage + "&pageSize=" + this.pageSize)
          .then((response) => {
            booksOfTypeVue.bookTypeList = response.data
            booksOfTypeVue.maxPage =response.data.length/ this.pageSize + 1
            if (response.data.length === 0) {
              document.getElementsByTagName("h3")[1].parentElement.style.display = "inline"
            }else{
              document.getElementsByTagName("h3")[1].parentElement.style.display = "none"
            }
            console.log(response)
          })
  }

  },

  created() {
    // this.initBooksOfTyle();
    console.log("booksOfTypeVue 对象创建完成了")
      this.bookTypeId = sessionStorage.getItem("typeId")
    console.log( sessionStorage.getItem("typeId") )
      this.getBooks(this.currentPage)
  }

});