
$(function () {

    let accountCheck = false;
    let passwordtCheck = false;

    //前端帳號格式判斷
    $('#account').blur(function (e) {
        e.preventDefault();

        let account = $('#account').val();
        let pass = /^(?=.*\d)(?=.*[a-zA-Z]).{4,20}$/;

        if (account.trim().length < 1 || !pass.test(account)) {
            $('#login').addClass('disabled');
            $('#message').text('帳號格式錯誤');
            accountCheck = false;
        } else {
            $('#login').removeClass('disabled');
            $('#message').empty();
            accountCheck = true;
        }

    });


    //前端密碼格式判斷
    $('#password').blur(function (e) {
        e.preventDefault();

        let password = $('#password').val();
        let pass = /^(?=.*\d)(?=.*[a-zA-Z]).{6,20}$/;

        if (password.trim().length < 1 || !pass.test(password)) {
            $('#login').addClass('disabled');
            $('#message').text('密碼格式錯誤');
            passwordtCheck = false;
        } else {
            $('#login').removeClass('disabled');
            $('#message').empty();
            passwordtCheck = true;
        }
    });

    //登入按鈕註冊Ajax請求
    $('#login').click(function (e) {
        //取消原按鈕功能
        e.preventDefault();

        //獲取帳號密碼
        let account = $('#account').val();
        let password = $('#password').val();


        if (!accountCheck) {
            $('#login').addClass('disabled');
            $('#message').text('請輸入帳號');
            return;
        }

        if (!passwordtCheck) {
            $('#login').addClass('disabled');
            $('#message').text('請輸入密碼');
            return;
        }

        //創建物件
        let data = {};
        data['account'] = account;
        data['password'] = password;

        $.ajax({
            url: '/user/login',
            type: 'POST',
            async: false,
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data),
            success: function (response) {
                if (response == 1) {
                    document.location.href = "/";
                } else if(response == -1) {
                    document.location.href = "/user/signup-success";
                } else {
                    $('#message').text('帳號或密碼錯誤，請重新輸入');
                }
            }
        });
    });


});

