package com.startsup.merchant.service;

import com.startsup.merchant.constants.Constants;
import com.startsup.merchant.database.repository.ItemsRepository;
import com.startsup.merchant.entities.Items;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
@Transactional
public class ItemService {

    private final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAllItems() {
        List<Items> items;
        try {
            items = itemsRepository.findAll();
        } catch (Exception e) {
            items = new ArrayList<>();
        }
        return items;
    }

    public List<Items> insertItems(Sheet sheet, Integer merchantId) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();
        List<Items> itemsList = new ArrayList<>();
        rowIterator.forEachRemaining(row -> {
            Items item = getItemFromRow(row, merchantId);
            itemsList.add(item);
        });
        List<Items> result = itemsRepository.saveAll(itemsList);
        return result;
    }

    private Items getItemFromRow(Row row, Integer merchantId) {
        Items item = new Items();
        item.setMerchantId(merchantId);
        int size = Constants.itemsHeader.size();
        IntStream.range(0, size).forEach(i -> {
            Cell cell = row.getCell(i);
            switch (Constants.itemsHeader.get(i)) {
                case "name":
                    String name = cell.getStringCellValue();
                    item.setName(name);
                    break;
                case "description":
                    String description = cell.getStringCellValue();
                    item.setDescription(description);
                    break;
                case "price":
                    if (cell.getCellType() == CellType.NUMERIC) {
                        item.setPrice(cell.getNumericCellValue());
                    } else {
                        String price = cell.getStringCellValue();
                        item.setPrice(Double.parseDouble(price));
                    }
                    break;
                case "category":
                    String category = cell.getStringCellValue();
                    item.setCategory(category);
                    break;
                case "isVeg":
                    boolean isVegBool = cell.getBooleanCellValue();
                    Byte myByte = (byte) (isVegBool ? 1 : 0);
                    item.setIsVeg(myByte);
                    break;
                case "customTax":
                    if (cell.getCellType() == CellType.NUMERIC) {
                        item.setCustomTax(cell.getNumericCellValue());
                    } else {
                        String tax = cell.getStringCellValue();
                        item.setCustomTax(Double.parseDouble(tax));
                    }
                case "customCommission":
                    if (cell.getCellType() == CellType.NUMERIC) {
                        item.setCustomCommission(cell.getNumericCellValue());
                    } else {
                        String customCommission = cell.getStringCellValue();
                        item.setCustomCommission(Double.parseDouble(customCommission));
                    }
            }
        });
        return item;
    }

    public Optional<Items> getItemById(int id) {
        Optional<Items> item = itemsRepository.findById(id);
        return item;
    }

    public List<Items> getAllItemsByMerchantId(int merchantId) {
        List<Items> items;
        try {
            items = itemsRepository.findItemsByMerchantId(merchantId);
        } catch (Exception e) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void saveItems(List<Items> itemsList) {
        itemsRepository.saveAll(itemsList);
    }

    public Optional<Items> updateItem(Items item) {
        try {
            return Optional.of(itemsRepository.save(item));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
