-- 코드를 입력하세요
SELECT count(*) AS USERS
FROM USER_INFO
WHERE YEAR(joined) = 2021 AND (age Between 20 and 29);