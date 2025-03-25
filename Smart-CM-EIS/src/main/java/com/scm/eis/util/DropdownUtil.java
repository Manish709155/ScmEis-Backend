package com.scm.eis.util;

import com.scm.eis.constant.Constants;
import com.scm.eis.custom.annotation.EnumLabel;
import com.scm.eis.exception.DataNotFoundRestException;
import com.scm.eis.model.DropdownEnumModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class DropdownUtil {

    public ResponseEntity<Object> getResponseEntity(Class enumClass) {
        return getResponseEntity(enumClass, false);
    }

    public ResponseEntity<Object> getResponseEntity(Class enumClass, boolean noSort) {
        try {
            return new ResponseEntity(getResponse(enumClass, noSort), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity(new DataNotFoundRestException(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<DropdownEnumModel> getResponse(Class enumClass, boolean noSort) {
        EnumLabel enumLabel = (EnumLabel) enumClass.getAnnotation(EnumLabel.class);
        Field labelField = FieldUtils.getField(enumClass, enumLabel != null ? enumLabel.name() : Constants.DISPLAY_NAME,
                true);
        List<DropdownEnumModel> responses = new ArrayList<>();
        List<Enum> enums = EnumUtils.getEnumList(enumClass);
        enums.forEach(value -> {
            try {
                String label;
                if (labelField != null) {
                    label = FieldUtils.readField(value, labelField.getName(), true).toString();
                } else {
                    label = WordUtils.capitalizeFully(value.toString().replace("_", " "));
                }
                if (!CommonUtil.isEmpty(label)) {
                    responses.add(new DropdownEnumModel(label, value.toString()));
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        });
        return responses;
    }

}
