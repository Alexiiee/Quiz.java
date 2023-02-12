const mysql = require("mysql");

const db = mysql.createConnection({
  host: "lms.cvuouqo0nhv9.ap-south-1.rds.amazonaws.com",
  port: "3306",
  user: "admin",
  password: "Rose_9619608750",
  database: "lms",
});

db.connect((err) =>{
  if (err) {
    console.log(err.message);
    return;
  }
  console.log("Database Connected sucessfully");
  db.query("SELECT * FROM Login, function (err, result, fields) {
    if(err) throw err;
    console.log(result);
});
});
conection .end();