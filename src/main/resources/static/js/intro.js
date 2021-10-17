$(function(){
    
    //自我介紹更新按鈕
    $('#updateIntro').click(function(e) {
    
        e.preventDefault();
        
        //抓取彈跳式表單中輸入的值
        let editIntroduceTitle = $('#editIntroduceTitle').val();
        let editIntroduceContent = $('#editIntroduceContent').val();
    
        //創建物件
        let intro = {};
        intro['introTitle'] = editIntroduceTitle;
        intro['introContent'] = editIntroduceContent;

        //將值放入自我介紹頁面
        if(editIntroduceTitle != ''){
            $('#introduceTitle').text(editIntroduceTitle);
        }
        if(editIntroduceContent != ''){
            $('#introduceContent').text(editIntroduceContent)
        }

        $.ajax({
            url: '/user/updateIntro',
            type: 'POST',
            async: false,
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(intro),
            success: function (response) {
                if (response){
                    $('#updateIntro').trigger('click');
                    return true;
                } else {
                    return false;
                }
            }
        });
    });

    //Link更新按鈕
    $('#updateLink').click(function(e) {
    
        e.preventDefault();
        
        //抓取彈跳式表單中輸入的值
        let fbLink = $('#fbLink').val();
        let igLink = $('#igLink').val();
        let ytLink = $('#ytLink').val();
        let mailLink = $('#mailLink').val();

        //修改a標籤的href連結
        if(fbLink != ''){
            $('#fbAddr').attr('href', fbLink);
        }
        if(igLink != ''){
            $('#igAddr').attr('href', igLink);
        }
        if(ytLink != ''){
            $('#ytAddr').attr('href', ytLink);
        }
        if(mailLink != ''){
            $('#mailAddr').attr('href', 'mailto:' + mailLink);
        }
        
        //創建物件
        let intro = {};
        intro['fbLink'] = fbLink;
        intro['igLink'] = igLink;
        intro['ytLink'] = ytLink;
        intro['emailLink'] = mailLink;

        $.ajax({
            url: '/user/updateIntroLink',
            type: 'POST',
            async: false,
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(intro),
            success: function (response) {
                if(response){
                    $('#updateLink').trigger('click');
                    return true;
                } else {
                    return false;
                }
            }
        });

    });
});

