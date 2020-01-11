
<html>
<body>
<fieldset>
<form action="./register" method="post">
<fieldset style ="width:10px">
<legend>Employee Details</legend>
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>

         </table>
</fieldset>
<br>

<fieldset style ="width:10px">
<legend>Employee Permanent Address</legend>
		<table>
			<tr>
				<td>Address Type:</td>
					<td><select name="addressBeans[0].addType">
					<option>---------------Select----------------</option>
					<option value="P">permanent Address</option>
					<option value="T">Temporary Address</option>
					</select>
					</td>
				
			</tr>

			<tr>
				<td>Address1:</td>
				<td><input type="text" name="addressBeans[0].address1"></td>
			</tr>

			<tr>
				<td>Address2:</td>
			
				<td><input type="text" name="addressBeans[0].address2"></td>
			</tr>

                </table>
</fieldset>
<br>

<fieldset style ="width:10px">

<legend>Employee temporary Deatails</legend>
		<table>
			<tr>
                               
				<td>Address:</td>
				<td><select  name="addressBeans[1].addType">
					<option value="P">permanent Address</option>
					<option value="T">Temporary Address</option>
					</select>
					</td>
				
                          
		</tr>

			<tr>
				<td>Address1:</td>
				<td><input type="text" name="addressBeans[1].address1"></td>
			</tr>

			<tr>
				<td>Address2:</td>
				<td><input type="text" name="addressBeans[1].address2"></td>
			</tr>

                </table>

</fieldset>
<br>
<table>
<tr>
<td><input  type="submit" value="Register"></td>
</tr>
</table>
</form>
<br>
</fieldset>
</body>
</html>