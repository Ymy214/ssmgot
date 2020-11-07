$(function () {
    // 初始化函数，将课程详情加粗边蓝
    $(".left-item:first").addClass("left-item2")
    $(".left-item a:first").addClass("addbule")

    // 单击课程目录的函数
    $(".left-item a:last").click(function () {
        $(".left-item:last").addClass("left-item2")
        $(".left-item a:last").addClass("addbule")
        $(".left-item:first").removeClass("left-item2")
        $(".left-item a:first").removeClass("addbule")
        $(".center-con").css("display","none")
        $(".center-con2").css("display","block")
    })

    // 单击课程详情的函数
    $(".left-item a:first").click(function () {
        $(".left-item:first").addClass("left-item2")
        $(".left-item a:first").addClass("addbule")
        $(".left-item:last").removeClass("left-item2")
        $(".left-item a:last").removeClass("addbule")
        $(".center-con2").css("display","none")
        $(".center-con").css("display","block")
    })

    // topfixed下拉到指定位置固定的函数
    $(".content").scroll(function(){
        $(".top-fixed").css("display","block")
    })
    
})