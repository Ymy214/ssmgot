//匀速运动 
function aveStart(dom,target){
            clearInterval(timer)
            var iSpeed = target - dom.offsetLeft > 0? 7:-7;
            timer = setInterval(function () {
                if (Math.abs(target - dom.offsetLeft) < Math.abs(iSpeed)) {
                    dom.style.left = parseInt(target)+"px"
                    clearInterval(timer);
                }
                else{
                    dom.style.left = dom.offsetLeft + iSpeed + 'px';
                }
            }, 50)
        }
//缓冲运动
function startBuffMove (dom, attrObj, callback) {
            clearInterval(dom.timer);
            var iSpeed = null, iCur = null;
            dom.timer = setInterval(function () {
                var bStop = true;
                for (var attr in attrObj) {
                    // 'width' 'height' 
                    if (attr == 'opacity') {
                        iCur = parseFloat( getStyle(dom, attr) ) * 100;
                    }else {
                        iCur = parseInt( getStyle(dom, attr) );
                    }
                    iSpeed = (attrObj[attr] - iCur) / 7;
                    iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
                    if (attr == 'opacity') {
                       dom.style.opacity = (iCur + iSpeed) / 100; 
                    }else {
                       dom.style[attr] = iCur + iSpeed + 'px';
                    }
                    if (iCur != attrObj[attr]) {
                        bStop = false;
                    }
                }
                if (bStop) {
                    clearInterval(dom.timer);
                    typeof callback == 'function' && callback();
                }
            }, 30);
        }
//弹性运动
 function startElaMove(dom, iSpeedX, iSpeedY) {
            clearInterval(dom.timer)
            var g = 3;
            dom.timer = setInterval(function () {
                iSpeedY += g
                var newTop = dom.offsetTop + iSpeedY
                var newLeft = dom.offsetLeft + iSpeedX
                if (newTop >= window.innerHeight - dom.clientHeight) {
                    iSpeedY *= -1
                    iSpeedY *= 0.8
                    iSpeedX *= 0.8
                    newTop = window.innerHeight - dom.clientHeight
                }
                if (newTop <= 0) {
                    iSpeedY *= -1
                    iSpeedY *= 0.8
                    iSpeedX *= 0.8
                    newTop = 0
                }
                if (newLeft >= window.innerWidth - dom.clientWidth) {
                    iSpeedX *= -1
                    iSpeedY *= 0.8
                    iSpeedX *= 0.8
                    newLeft = window.innerWidth - dom.clientWidth
                }
                if (newLeft <= 0) {
                    iSpeedX *= -1
                    iSpeedY *= 0.8
                    iSpeedX *= 0.8
                    newLeft = 0
                }
                if (Math.abs(iSpeedY) < 1) {
                    iSpeedY = 0
                }
                if (Math.abs(iSpeedX) < 1) {
                    iSpeedX = 0
                }
                if (iSpeedY == 0 && iSpeedX == 0 && newTop == window.innerHeight - dom.clientHeight) {
                    clearInterval(dom.timer)
                } else {
                    dom.style.top = newTop + 'px'
                    dom.style.left = newLeft + 'px'
                }
            }, 30)
        }
//查看滚动条滚动距离
 function getScrollOffset(){
            if(window.pageXOffset){
                return {
                    x:pageXOffset,
                    y:pageYOffset
                }
            }else{
                return {
                    x:document.body.scrollLeft + document.documentElement.scrollLeft,
                    y:document.body.scrollTop + document.documentElement.scrollTop
                }
            }
        }
//查看可视窗口兼容性方法
 function getViewportOffset(){
           if(window.innerHeight){
               return {
                   w:window.innerWidth,
                   h:window.innerHeight
               }
           }else{
               if(document.compatMode == "BackCompat"){
                   return {
                       w:document.body.clientWidth,
                       h:document.body.clientTop
                   }
               }else{
                   return {
                       w:document.documentElement.clientWidth,
                       h:document.documentElement.clientHeight
                   }
               }
           }
       }
//获取计算样式
 function getStyle (dom, attr) {
            if (window.getComputedStyle) {
                return window.getComputedStyle(dom, null)[attr];
            }else {
                return dom.currentStyle[attr];
            }
        }
//绑定事件的方法
 function addEvent(dom,type,handle){
          if(dom.addEventListener){
            dom.addEventListener('type',handle,false)
          }else if(dom.attachEvent){
            dom.attachEvent(on + 'type',function(){
                handle.call(dom)
            })
          }else{
              dom[on + 'type'] = handle
          }
      }
//取消事件冒泡
function cancalPop(e){
        if(e.stopPropagation){
            e.stopPropagation
        }else{
            e.cancalBubble = true
        }
     }