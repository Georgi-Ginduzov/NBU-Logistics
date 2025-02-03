package com.example.logistics.services;

import com.example.logistics.dtos.OfficeDto;
import com.example.logistics.models.Office;
import com.example.logistics.repositories.interfaces.OfficeRepository;
import com.example.logistics.services.interfaces.OfficeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OfficeServiceImplTests {

    @Mock
    private OfficeRepository officeRepository;

    @InjectMocks
    private OfficeServiceImpl officeService;

    @Test
    void testFindAll() {
        // Given
        Office office1 = new Office();
        Office office2 = new Office();
        when(officeRepository.findAll()).thenReturn(Arrays.asList(office1, office2));

        // When
        List<OfficeDto> offices = officeService.findAll();

        // Then
        assertNotNull(offices);
        assertEquals(2, offices.size());
    }

    @Test
    void testAddOffice() {
        // Given
        OfficeDto officeDto = new OfficeDto();
        officeDto.setLocation("New York");
        officeDto.setAddress("123 Main St");

        Office office = new Office();
        when(officeRepository.save(any(Office.class))).thenReturn(office);

        // When
        OfficeDto result = officeService.add(officeDto);

        // Then
        assertNotNull(result);
    }

    @Test
    void testUpdateOffice() {
        // Given
        Long officeId = 1L;
        OfficeDto updatedOfficeDto = new OfficeDto();
        updatedOfficeDto.setLocation("Los Angeles");

        Office office = new Office();
        office.setId(officeId);
        office.setLocation("New York");

        when(officeRepository.findById(officeId)).thenReturn(java.util.Optional.of(office));
        when(officeRepository.save(office)).thenReturn(office);

        // When
        OfficeDto result = officeService.update(officeId, updatedOfficeDto);

        // Then
        assertNotNull(result);
        assertEquals(updatedOfficeDto.getLocation(), result.getLocation());
    }

    @Test
    void testDeleteOffice() {
        // Given
        Long officeId = 1L;
        when(officeRepository.existsById(officeId)).thenReturn(true);

        // When
        officeService.delete(officeId);

        // Then
        verify(officeRepository, times(1)).deleteById(officeId);
    }
}
