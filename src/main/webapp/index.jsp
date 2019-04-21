<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <c:url value="/index.js" var="indexScriptUrl"/>
    <c:url value="/login.js" var="loginScriptUrl"/>
    <c:url value="/profile.js" var="profileScriptUrl"/>
    <c:url value="/logout.js" var="logoutScriptUrl"/>
    <script src="${indexScriptUrl}"></script>
    <script src="${loginScriptUrl}"></script>
    <script src="${profileScriptUrl}"></script>
    <script src="${logoutScriptUrl}"></script>
    <title>AJAX Poets</title>
    <link rel="stylesheet" type="text/css" href="TemplateForMyself_text.css">
</head>
    <body>
        <div class="wrapper">
            
            <div id="profile-content" class="hidden content">
                <div class="container">
                    <div class="containerhead">
                        <div class="title"><a href="">Your poems</a></div>
                    </div>
                    <h1>Placeholder</h1>
                        for ciklus regények ajax.
                    <div class="containerfoot"></div>
                </div>
            </div>
            <div class= "rightcoloumn">
                <div class="loginbox" >
                        <div class="loginboxsubstyle">
                            <div id="login-content" >
                                <div class="desc">
                                    <div class="containerhead">
                                        <div id="login-title" class="title">Login</div>
                                    </div>
                                    <form id="login-form" onsubmit="return false;" class="">
                                        Name: <br>
                                        <input type="text" name="name">
                                        <br>
                                        Password: <br/>
                                        <input type="text" name="password">
                                        <button id="login-button">Login</button>
                                    </form>

                                    <div id="showprofile-content" class="hidden">
                                        <p>Name: <span id="user-name"></span></p>
                                        <p>Password: <span id="user-password"></span></p>
                                    </div>
                                    <div id="logout-content" class="hidden">
                                        <button id="logout-button">Logout</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            
                <div class="sidebar1">
                    <div class="sbcontainer1">

                        <div class="desc">
                            <div class="containerhead">
                                <div class="profile-title">Profile</div>
                            </div>
                            <p>
                                Some sidebar text. and links
                            </p>
                        </div>

                        <ul class="search">
                            <form action="login" method="post" id="search-form">
                                Name: <br>
                                <input type="text" name="name">
                                <br>
                                <button id="search-button">Search</button>
                            </form>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
