<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.LinkedList" %>
<jsp:useBean id="result" class="app.entities.Bean" scope="session" type="app.entities.Bean"/>
<%--
  Created by IntelliJ IDEA.
  User: piros
  Date: 10/16/2020
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML >
<html>
<title>Веб-программирование</title>
<header id="head">

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!--connecting a style sheet-->
  <link rel="stylesheet" href = "style_21.css">

  <section class="gif">
    <img src="пингвинчик.gif" alt="тут был пингвинчик">
  </section>

  <p>Лабораторная работа №2, Bариант 2737 </p>
  <p>Выполнили: Полозова Екатерина, Кудлаков Роман (P3231)</p>

</header>
<body>

<div id="caption">

</div>
<div id="main">

  <!--coordinate plane-->
  <svg >
    <line x1="0" x2="300" y1="150" y2="150" stroke="black"></line>
    <line x1="150" x2="150" y1="0" y2="300" stroke="black"></line>
    <polygon points="150,0 144,15 156,15" stroke="black"></polygon>
    <polygon points="300,150 285,156 285,144" stroke="black"></polygon>

    <line x1="200" x2="200" y1="155" y2="145" stroke="black"></line>
    <line x1="250" x2="250" y1="155" y2="145" stroke="black"></line>

    <line x1="50"  x2="50"  y1="155" y2="145" stroke="black"></line>
    <line x1="100" x2="100" y1="155" y2="145" stroke="black"></line>

    <line x1="145" x2="155" y1="100" y2="100" stroke="black"></line>
    <line x1="145" x2="155" y1="50"  y2="50"  stroke="black"></line>

    <line x1="145" x2="155" y1="200" y2="200" stroke="black"></line>
    <line x1="145" x2="155" y1="250" y2="250" stroke="black"></line>

    <text x="195" y="140">R/2</text>
    <text x="248" y="140">R</text>

    <text x="40" y="140">-R</text>
    <text x="90" y="140">-R/2</text>

    <text x="160" y="105">R/2</text>
    <text x="160" y="55">R</text>

    <text x="160" y="205">-R/2</text>
    <text x="160" y="255">-R</text>

    <polygon class="rectangle" points="250,150 150,150 150,200, 250,200"
             fill="#FF69B4" fill-opacity="0.3" stroke="#FF69B4"></polygon>

    <path class="circle" d="M 50 150 A 100 100, 90, 0, 0, 150 250 L 150 150 Z"
          fill="#FF4500" fill-opacity="0.3" stroke="#FF4500"></path>

    <polygon class="triangle" points="50,150 150,150 150,50"
             fill="#FFA500" fill-opacity="0.3" stroke="#FFA500"></polygon>

    <circle r="3" cx="150" cy="150" id="target-dot" fill = "red" ></circle>

  </svg>

  <!--submitting-->
  <p><input id="button" class="form_button" type="submit" name="button" value="Жмяк"></p>

  <div id="form">

    <form id="f" method="POST" action = "controllerServlet">
      <!--input x-->
      <section  class="x" id="x_text">
        <p>X value:</p>
        <!--radiobutton-->
        <table class = "table_y">
          <!--first row-->
          <tr>
            <td><div class="block">
              <label>
                <input type = "radio" name = "x" id = "radio1" value = "-2">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio1">-2</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio2" value = "-1.5">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio2">-1.5</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio3" value = "-1">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio3">-1</label></td>
          </tr>

          <!--second row-->
          <tr>
            <td><div class="block">
              <label>
                <input type = "radio" name = "x" id = "radio4" value = "-0.5">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio4">-0.5</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio5" value = "0">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio5">0</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio6" value = "0.5">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio6">0.5</label></td>
          </tr>

          <!--third row-->
          <tr>
            <td><div class="block">
              <label>
                <input type = "radio" name = "x" id = "radio7" value = "1">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio7">1</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio8" value = "1.5">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio8">1.5</label></td>

            <td><div class = "block">
              <label>
                <input type = "radio" name = "x" id = "radio9" value = "2">
                <span class = "box"></span>
              </label>
            </div></td>
            <td><label for = "radio9">2</label></td>
          </tr>

        </table>
      </section>

      <!--input y-->
      <section class="y" id="checkbox_y">
        <p>Y value:</p>
        <input type="text" name="y" id="text_field" onchange ="validate_y()"><br>
        <p>y &#8712; (-5; 3)</p>
      </section>

      <!--input R-->
      <section class="R">
        <p>Radius:</p>
        <table class="table_R">
          <!--first row-->
          <tr>
            <td><div class="block">
              <label>
                <input type="checkbox" name="R" value = "1" id="checkbox10">
                <span class="box"></span>
              </label>
            </div></td>
            <td><label for="checkbox10">1</label></td>

            <td><div class="block">
              <label>
                <input type="checkbox" name="R" value = "2" id="checkbox11">
                <span class="box"></span>
              </label>
            </div></td>
            <td><label for="checkbox11">2</label></td>

            <td><div class="block">
              <label>
                <input type="checkbox" name="R" value = "3" id="checkbox12">
                <span class="box"></span>
              </label>
            </div></td>
            <td><label for="checkbox12">3</label></td>
          </tr>
          <!--second row-->
          <tr>
            <td><div class="block">
              <label>
                <input type="checkbox" name="R" value = "4" id="checkbox13">
                <span class="box"></span>
              </label>
            </div></td>
            <td><label for="checkbox13">4</label></td>

            <td><div class="block">
              <label>
                <input type="checkbox" name="R" value = "5" id="checkbox14">
                <span class="box"></span>
              </label>
            </div></td>
            <td><label for="checkbox14">5</label></td>
          </tr>
        </table>
      </section>
    </form>
  </div>
</div>

<div id = "result">
  <table id = "resultTable">
    <tr>
      <th>Координата X</th>
      <th>Координата Y</th>
      <th>Радиус</th>
      <th>Результат</th>
      <th>Время работы скрипта</th>
      <th>Текущее время</th>
    </tr>
      <jsp:setProperty name="result" property="bean" value="${sessionScope.bean.bean}"/>

      <% if (result.getBean() != null){
          for (HashMap<String, String> line : result.getBean()){
              if (line != null){ %>
      <tr>
          <td><%= line.get("x") %></td>
          <td><%= line.get("y") %></td>
          <td><%= line.get("R") %></td>
          <% if (line.get("result").equals("true")) {%>
          <td> &#9989 </td>
          <% } else { %>
          <td> &#10060 </td>
          <% } %>
          <td><%= line.get("workTime") %>мс</td>
          <td><%= line.get("currentTime") %></td>
      </tr>
      <% }
      }
    }
    %>

  </table>
</div>


<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type = "text/javascript">

  //function click() {
    $(document).ready(
            document.querySelector("svg").addEventListener("click", (ev) => {
              //get svg element
              const target = document.querySelector("svg").getBoundingClientRect();
              const svg = $("svg");

              //get some css attributes for svg
              const padding_top = parseInt(svg.css("padding-top"));
              const border_width_top = parseInt(svg.css("border-top-width"));
              const padding_left = parseInt(svg.css("padding-left"));
              const border_width_left = parseInt(svg.css("border-left-width"));

              //count x and y of the point on svg
              const x = String(ev.clientX - target.left - padding_left - border_width_left);
              const y = String(ev.clientY - target.top - padding_top - border_width_top);

              //check if R is set
              const checkedR = document.querySelectorAll("input:checked[name=R]");
              if (checkedR.length === 0){
                if (document.getElementById("error") == null) {
                  error("You haven't chosen any value for Radius", 0);
                }
                return;
              }

              let valX = (parseInt(x) - 150)/100;
              let valY = -(parseInt(y) - 150)/100;
              if (Math.abs(valY) > 1.4 || Math.abs(valX) > 1.4){
                if (document.getElementById("error") == null) {
                  error("The point isn't on the coordinate plane", 0);
                }
                return;
              }

              //set point
              document.getElementById("target-dot").setAttribute("cx", x);
              document.getElementById("target-dot").setAttribute("cy", y);

              const form = makeForm(valX, valY, checkedR, 1);
              sendForm(form);
            }));
  //}
  $(document).ready(

          $("#button").click(function () {
            if (valid() && validate_y()) onclick();
          })
  );

  function error(txt, value = 1){
    console.log('1');
    //main block with elements
    const parent = document.getElementById("form");
    //nodes to change
    const node1 = document.getElementById("checkbox_y");
    const node2 = document.querySelector('.R');
    const node3 = document.getElementById("x_text");

    document.querySelector(".form_button").setAttribute("disabled", true);

    //text
    const text = document.createTextNode("! " + txt + " !");
    const span = document.createElement("span");
    span.appendChild(text);
    span.style = "color: red";
    const p = document.createElement("p");
    p.appendChild(span);
    //pic error
    const img = document.createElement("img");
    img.src = "злой_пингвинчик.gif";
    img.style.border = "6px dotted #CD5C5C";
    const container = document.createElement("p");
    container.appendChild(img);
    //new section
    const section = document.createElement("section");
    section.appendChild(p);
    section.appendChild(container);
    section.id = "error";
    section.padding = 1;

    disappear(node1);
    disappear(node2);
    disappear(node3);

    parent.appendChild(section);

    setTimeout(() =>{
      parent.removeChild(document.getElementById("error"));
      appear(node1);
      appear(node2);
      appear(node3);

      if (value === 0){
        document.querySelector(".form_button").removeAttribute("disabled");
      }
    }, 2000);
  }

  function validate_y() {
    //input field for y coordinate
    const val = document.getElementById("text_field").value;
    //checking
    if (isNaN(val) || document.getElementById("text_field").value.trim().length === 0) {
      error("y have to be a number");
      return false;
    }

    if (val.indexOf(".") !== -1) {
      if (val.slice(0, val.indexOf(".")) >= 3 || val.slice(0, val.indexOf(".")) <= -5) {
        error("y must be in the interval (-5; 3)");
        return false;
      }
    } else if (val <= -5 || val >= 3) {
      error("y must be in the interval (-5; 3)");
      return false;
    }

    document.querySelector(".form_button").removeAttribute("disabled");
    return true;
  }
  //function to hide an element
  function disappear(element){
    element.classList.add("disappear");
  }
  //function to return an element
  function appear(element){
    element.classList.remove("disappear");
  }
  //error message and button lock

  //scroll to the table of results
  document.querySelector('#button').addEventListener('click', () => {
    if(document.querySelector("#error")) return;
    setTimeout(() => window.scrollTo(0,document.body.scrollHeight), 1000);
  });


  function valid(){
    const x = document.querySelector('input:checked[name=x]');
    const allR = document.querySelectorAll('input:checked[name=R]');

    if (x === null){
      error("You haven't chosen any value for X", 0);
      return false;
    } else if (allR.length === 0){
      error("You haven't chosen any value for Radius", 0);
      return true;
    }
    return true;
  }


  function onclick(){
    const valX = document.querySelector("input:checked[name=x]").getAttribute("value");
    const valY = document.querySelector("#text_field").value;
    const checkedR = document.querySelectorAll("input:checked[name=R]");
    console.log("onclick");
    const form = makeForm(valX, valY, checkedR, 0);
    sendForm(form);
  }

  function makeForm(valX, valY, checkedR, degree) { //degree is allowed to multiply by R or not if it's the data from the form

    // it's necessary to multiply x and y by R
    const form = new FormData();
    for (let i = 0; i < checkedR.length; i++) {
      if (degree === 1) {
        form.append('x[' + i + ']', String((valX * Math.pow(checkedR[i].getAttribute("value"), degree)).toFixed(2)));
        form.append('y[' + i + ']', String((valY * Math.pow(checkedR[i].getAttribute("value"), degree)).toFixed(2)));
        form.append('R[' + i + ']', checkedR[i].getAttribute("value"));
      } else{
        form.append('x[' + i + ']', valX);
        form.append('y[' + i + ']', valY);
        form.append('R[' + i + ']', checkedR[i].getAttribute("value"));
      }
    }
    return form;
  }

  function sendForm(form) {
    $(document).ready(function () {
      $.ajax({
        method: "POST",
        url: "controllerServlet",
        processData: false,
        contentType: false,
        data: form,

        dataType: "json",
        success: function (res) {
          setResult(res);
          console.log("success");
        },
        statusCode: {
          200: function () {
            console.log("Ok");
          }
        }
      });
    });
  }

  function setResult(res){
    const html = String("<table id = 'resultTable'>" +
            " <tr> " +
            "<th>Координата X</th> " +
            "<th>Координата Y</th> " +
            "<th>Радиус</th>" +
            " <th>Результат</th> " +
            "<th>Время работы скрипта</th>" +
            " <th>Текущее время</th> " +
            "</tr>");
    let data = "";
    for (let i = 0; i < res.length; i++){

      data += "<tr>";
      data += "<td>" + res[i]["x"] + "</td>";
      data += "<td>" + res[i]["y"] + "</td>";
      data += "<td>" + res[i]["R"] + "</td>";
      if (res[i]["result"] === "true") {
          data += "<td> &#9989 </td>";
      } else{
          data += "<td> &#10060 </td>";
      }
      data += "<td>" + res[i]["workTime"] + "мс </td>";
      data += "<td>" + res[i]["currentTime"] + "</td>";
      data += "</tr>";
    }

    document.getElementById("result").innerHTML = html + data + "</table>";
    console.log(res.length);
  }

</script>
</body>
</html>

