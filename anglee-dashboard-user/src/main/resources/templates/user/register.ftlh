<html>
<#include "../common/header.ftlh">

<body>
    <#--content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/user/register.do">
                        <div class="form-group">
                            <label>username</label>
                            <input name="username" type="text" class="form-control"
                                   value=""/>
                        </div>
                        <div class="form-group">
                            <label>password</label>
                            <input name="password" type="password" class="form-control"
                                   value=""/>
                        </div>
                        <div class="form-group">
                            <label>email</label>
                            <input name="email" type="email" class="form-control"
                                   value=""/>
                        </div>
                        <div class="form-group">
                            <label>phone</label>
                            <input name="phone" type="number" class="form-control"
                                   value=""/>
                        </div>

                        <div class="form-group">
                            <label>role</label>
                            <input name="role" type="text" class="form-control"
                                   value=""/>
                        </div>
                        <div class="form-group">
                            <label>question</label>
                            <input name="question" type="text" class="form-control"
                                   value=""/>
                        </div>
                        <div class="form-group">
                            <label>answer</label>
                            <input name="answer" type="text" class="form-control"
                                   value=""/>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>