$(function () {
    let flag = true;

    //編輯按鈕註冊
    $('#edit').click(function (e) {
        e.preventDefault();

        $('#editZone > button').toggle();

        if (flag) {
            $('#name').prop('disabled', false);
            $('#nickname').prop('disabled', false);
            $('#birthday').prop('disabled', false);
            $('#email').prop('disabled', false);
            $('#phone').prop('disabled', false);

            $('#gender').removeClass('bg-white');
            $('#account').removeClass('bg-white');
            $('#signupday').removeClass('bg-white');
            flag = false;
        } else {
            $('#name').prop('disabled', true);
            $('#nickname').prop('disabled', true);
            $('#birthday').prop('disabled', true);
            $('#email').prop('disabled', true);
            $('#phone').prop('disabled', true);
            $('#message').hide();
            $('input').removeClass('border border-1 border border-danger');

            $('#gender').addClass('bg-white');
            $('#account').addClass('bg-white');
            $('#signupday').addClass('bg-white');
            flag = true;
        }

    });

    //取消按鈕註冊
    $('#cancel').click(function (e) {
        e.preventDefault();


        $.ajax({
            url: '/user/getUser',
            type: 'GET',
            success: function (response) {

                $('#name').val(response.name);
                $('#nickname').val(response.nickname);
                $('#birthday').val(response.birthday);
                $('#email').val(response.email);
                $('#phone').val(response.phone);
                $('#edit').trigger('click');
            }

        });

    });

    //密碼更改按鈕註冊
    $('#changePassword').click(function (e) {
        e.preventDefault();

        $.ajax({
            url: '/user/changePassword',
            type: 'GET'
        });
    });

    //前端姓名格式判斷
    $('#name').blur(function (e) {
        e.preventDefault();

        let name = $('#name').val();

        if (name.trim().length < 2) {
            $('#name').addClass('border border-1 border border-danger');
            $('#submit').addClass('disabled');
            $('#message').show().text('姓名格式錯誤');
        } else {
            $('#name').removeClass('border border-1 border border-danger');
            $('#submit').removeClass('disabled');
            $('#message').empty();
        }
    });

    //前端暱稱格式判斷
    $('#nickname').blur(function (e) {
        e.preventDefault();

        let nickname = $('#nickname').val();

        if (nickname.trim().length < 1) {
            $('#nickname').addClass('border border-1 border border-danger');
            $('#submit').addClass('disabled');
            $('#message').show().text('暱稱格式錯誤');
        } else {
            $('#nickname').removeClass('border border-1 border border-danger');
            $('#submit').removeClass('disabled');
            $('#message').empty();
        }

    });

    //前端信箱格式判斷
    $('#email').blur(function (e) {
        e.preventDefault();

        let email = $('#email').val();
        let pass = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;

        if (email.trim().length < 1 || !pass.test(email)) {
            $('#email').addClass('border border-1 border border-danger');
            $('#submitn').addClass('disabled');
            $('#message').show().text('信箱格式錯誤');
        } else {
            $('#email').removeClass('border border-1 border border-danger');
            $('#submitn').removeClass('disabled');
            $('#message').empty();
        }

    });

    //前端手機格式判斷
    $('#phone').blur(function (e) {
        e.preventDefault();

        let phone = $('#phone').val();
        let pass = /09\d{8}/;


        if (pass.test(phone) || phone.trim() < 1) {
            $('#phone').removeClass('border border-1 border border-danger');
            $('#submit').removeClass('disabled');
            $('#message').empty();
        } else {
            $('#phone').addClass('border border-1 border border-danger');
            $('#submit').addClass('disabled');
            $('#message').show().text('手機格式錯誤');
        }

    });



    //提交按鈕註冊Ajax請求
    $('#submit').click(function (e) {

        e.preventDefault();

        let name = $('#name').val();
        let nickname = $('#nickname').val();
        let birthday = $('#birthday').val();
        let email = $('#email').val();
        let phone = $('#phone').val();

        if (name.trim() < 1 || nickname.trim() < 1 || email.trim() < 1) {
            $('#message').show().text('麻煩請先填寫完成');
            return;
        } else {
            $('#message').empty();
        }


        //創建物件
        let user = {};
        user['name'] = name;
        user['nickname'] = nickname;
        user['birthday'] = birthday;
        user['email'] = email;
        user['phone'] = phone;


        $.ajax({
            url: '/user/updateUser',
            type: 'POST',
            async: false,
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(user),
            success: function (response) {
                if(response) {
                    $('#result').text('').show();
                    $('#cancel').trigger('click');
                    $('#result').text('修改成功').hide(3000);

                } else {
                    $('#result').text('').show();
                    $('#result').text('修改失敗').hide(3000);
                }
            }
        });
    });

});

