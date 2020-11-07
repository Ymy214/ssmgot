var omyCourse = document.getElementsByClassName('all-course-content')[0]
var oul = document.getElementsByClassName("recommentcourse")[0].getElementsByTagName("ul")[0]

myCourseData.forEach(function(ele,index){
    omyCourse.innerHTML += `<div class="courseitem">
    <div class="img-box">
        <a href="#">
            <img src="${ele.url}" height="116" width="200"/>
        </a>
    </div>
    <div class="course-list">
        <div class="title">
            <span>${ele.title_span}</span>
            <a href="#">${ele.title_a}</a>
        </div>
        <div class="study-part">
            <span class="i-left span-common">${ele.study_rate}</span>
            <span class="span-common">${ele.study_min}</span>
            <span class="span-common">${ele.study_intro}</span>
        </div>
        <div class="points">
            <span>
                <a href="#">${ele.note}</a>
                <i>0</i>
            </span>
            <span>
                <a href="#">${ele.code}</a>
                <i>0</i>
            </span>
            <span>
                <a href="#">${ele.ask}</a>
                <i>0</i>
            </span>
            <a href="#" class="continue-btn" onclick="window.location.href='coursedetails.html'">${ele.btn}</a>
        </div>
    </div>
</div>`
})
recommedCourseData.forEach(function(ele,index){  
    oul.innerHTML += `<li>
    <a href="#">
        <div class="img">
            <img src="${ele.url}" height="120" width="216"/>
        </div>
        <div class="content">
            <p class="title">${ele.title}</p>
            <div class="r-content">
                <span>${ele.price}</span>
                <span>${ele.level}</span>
                <span>${ele.courseNo}</span>
            </div>
        </div>
    </a>
</li>`
})
$(document).ready(function(){

	$('#search-input').bind('keyup', function() {

		var jqueryInput = $(this);

		//用户输入

		var searchText = jqueryInput.val();

		//请求必应的服务器，获得相关搜索信息

		$.get('http://localhost.8080/ike/api/hot_course?nu=12' + searchText,function(json){

			//服务器返回的信息

			var data = json.AS.Results[0].Suggests;

			var html="";

			//将服务器返回的信息加到li标签里

			for(var i = 0; i < data.length; i++){

				html += '<li>' + data[i].Txt + '</li>';

			}

			$('#search-result').html(html);

			$('#search-suggest').show().css({

			top: $('#search-form').offset().top+$('#search-form').height()+10,

			left: $('#search-form').offset().left,

			// $('#search-form').offset().left的结果是468.5 

			// 不知道为什么left不加4只有464.25的宽度

			position: 'absolute'

			});

		},'json');

	});

	$(document).bind('click',function(event) {

		// 隐藏搜索结果

		$('#search-suggest').hide();

	});

	$(document).delegate('li', 'click', function(event) {

		var li_text = $(this).text();//取到li里的文本

		//返回结果的链接

		location.href = 'http://cn.bing.com/search?q=' + li_text;

	});

});
$.ajax({
	url:'js/data.js',
	type:'post',
	dataType:'js',
	success:function (data) {
		console.log(data)
	}

})