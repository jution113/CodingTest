-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_NAME_INFO AS name_info
    JOIN FISH_INFO AS info
    ON name_info.FISH_TYPE = info.FISH_TYPE
WHERE name_info.FISH_NAME = 'BASS'
    OR name_info.FISH_NAME = 'SNAPPER';