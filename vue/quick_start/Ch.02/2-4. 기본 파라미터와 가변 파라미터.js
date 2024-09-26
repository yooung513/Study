// 기본 파라미터
function addContact(name, mobile, home="없음", address="없음", email="없음") {
    var str = `name=${name}, mobile=${mobile}, home=${home}, ` +
                `address=${address}, email=${email}`
    
    console.log(str);
}

addContact("홍길동", "010-222-3331");
addContact("이몽룡", "010-222-3331", "02-3422-9900", "서울시");


// 가변 파라미터
function foodReport(name, age, ...favoriteFoods) {
    console.log(name + ", " + age);
    console.log(favoriteFoods);
}

foodReport("이몽룡", 20, "짜장면", "냉면", "불고기");
foodReport("홍길동", 16, "초밥");