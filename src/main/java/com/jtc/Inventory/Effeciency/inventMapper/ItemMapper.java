package com.jtc.Inventory.Effeciency.inventMapper;

import com.jtc.Inventory.Effeciency.inventDto.ItemDto;
import com.jtc.Inventory.Effeciency.inventoryEntities.Item;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;


import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
public class ItemMapper {

    private final ModelMapper modelMapper;

    public ItemDto getItemDto(Item item)
    {
        return modelMapper.map(item, ItemDto.class);
    }
    public Item getItem(ItemDto dto)
    {
        return modelMapper.map(dto, Item.class);
    }
    public List<ItemDto> getItemDtoList(List<Item>itemList)
    {
        return itemList.stream().map(e-> modelMapper.map(e, ItemDto.class) ).toList();
    }
    public List<ItemDto> mapperItemDtoList(List<Item>itemList)
    {
        Type listType = new TypeToken<List<ItemDto>>(){}.getType();
        return modelMapper.map(itemList,listType);
    }

}
