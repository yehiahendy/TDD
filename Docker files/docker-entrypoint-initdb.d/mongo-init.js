var isAuth = db.auth("root","1234");

if(isAuth)
{
    var arrayOfStudents = [{
        "id": 0,
        "Name": "Yehia",
        "Dgree":100
      }, {
        "id": 1,
        "Name": "Ahmed",
        "Dgree":90
      }, {
        "id": 2,
        "Name": "Mohamed",
        "Dgree":80
      },{
        "id": 3,
        "Name": "Youssef",
        "Dgree":98
      }];
    print("User is authenticated");
    db = db.getSiblingDB('TDD');
    db.createUser(
    {
    user: 'user',
    pwd: '1234',
    roles: [{ role: 'readWrite', db: 'TDD' }],
    },);
db.createCollection('users');
for(var i = 0 ; i < arrayOfStudents.length;i++)
    db.users.insert(arrayOfStudents[i]);
}
else
{
    print("User is not auth");
}
