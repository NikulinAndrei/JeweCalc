<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Jewelery calculator</title>
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/additional-methods.js"></script>

    <script type="text/javascript">
    var validateOptions = {
                            rules: {
                             probe : { required : true, digits: true, min: 1, max: 1000,  minlength: 1, maxlength: 4 } ,
                             weight : { required : true, digits: true, min: 1,  minlength: 1, maxlength: 8 }
                            }
                          };

    $(document).ready(function(){
      $("#calcForm").validate(validateOptions);

      $("#submit").click( function() {
        $("#calcForm").valid();
        calculate();
        });
     });


     function calculate( ) {
     $.ajax({
          type: "POST",
          url: "getQuote",
          data: $("#calcForm").serialize(),
          success: function(data){
             $("#price").val( data );
          }
        });

      $.ajax({
         type: "POST",
         url: "calculatePrice",
         data: $("#calcForm").serialize(),
         success: function(data){
            $("#output"). prepend( data );
         }
       });
     }


    </script>


</head>
<body>
    <div class="container">
        <form class="form-horizontal" method="post" id="calcForm">
            <legend>Provide your jewelery data</legend>

            <div class="control-group">
                <label class="control-label" for="material">Metal</label>
                <div class="controls">
                    <select name="material" id="material">
                        <option value="GOLD" >Gold</option>
                        <option value="SILVER" >Silver</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="unit">Weight unit</label>
                <div class="controls">
                    <select name="unit" id="unit">
                        <option value="g"  >Grams</option>
                        <option value="oz" >OZ</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="currency">Currency</label>
                <div class="controls">
                    <select name="currency" id="currency">
                        <option value="USD" >USD</option>
                        <option value="EUR"  >EUR</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="price">Stock price</label>
                <div class="controls">
                    <input type="text" name="price" id="price" readonly="readonly" value=""/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="probe">Probe</label>
                <div class="controls">
                    <input type="text" name="probe" id="probe" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="weight">Weight</label>
                <div class="controls">
                    <input type="text" name="weight" id="weight"  />
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input type="button" class="btn btn-primary" name="submit" id="submit" value="Calculate"></input>
                </div>
            </div>

            <div id="output">

            </div>

        </form>
    </div>
</body>
</html>