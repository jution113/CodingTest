-- 코드를 작성해주세요
SELECT child_info.ITEM_ID, child_info.ITEM_NAME, child_info.RARITY
FROM ITEM_INFO AS child_info
    INNER JOIN ITEM_TREE AS tree
    ON child_info.ITEM_ID = tree.ITEM_ID
    INNER JOIN ITEM_INFO AS parent_info
    ON tree.PARENT_ITEM_ID = parent_info.ITEM_ID
WHERE parent_info.RARITY = 'RARE'
ORDER BY child_info.ITEM_ID DESC;