    $(function(){

        // 右侧浮窗mouseover和mouseout
        $(".feedback").mouseover(function(){
            $(".feedback i").css("display","none")
            $(".feedback span").css("display","block")
        }),
        $(".feedback").mouseout(function(){
            $(".feedback i").css("display","block")
            $(".feedback span").css("display","none")
        }),
        

        $(".help").mouseover(function(){
            $(".help i").css("display","none")
            $(".help span").css("display","block")
        }),
        $(".help").mouseout(function(){
            $(".help i").css("display","block")
            $(".help span").css("display","none")
        }),
        

        $(".backtop").mouseover(function(){
            $(".backtop i").css("display","none")
            $(".backtop span").css("display","block")
        }),
        $(".backtop").mouseout(function(){
            $(".backtop i").css("display","block")
            $(".backtop span").css("display","none")
        })


        // 导航栏内容变色
        $(".header-container a").mouseover(function(){
            $(this).css("color","#3377ff")
        })
        $(".header-container a").mouseout(function(){
            $(this).css("color","#1c1f21")
        })
        $(".header-container  .login a").mouseover(function(){
            $(this).css("color","red")
        })
        $(".header-container .login a").mouseout(function(){
            $(this).css("color","#545c63")
        })

        // .mian-list内容变色
        $(".tlt-con").mouseover(function(){
            $(this).css("color","#37f")
        })
        $(".tlt-con").mouseout(function(){
            $(this).css("color","#1c1f21")
        })
        $(".author-box span").mouseover(function(){
            $(this).siblings().css("color","#37f")
            $(this).css("color","#37f")
        })
        $(".author-box span").mouseout(function(){
            $(this).siblings("span").css("color","#1c1f21")
            $(this).css("color","#1c1f21")
        })
        $(".main-li").click(function () {
            window.location.href = 'specialcourseDetails.html'
        })
    })
