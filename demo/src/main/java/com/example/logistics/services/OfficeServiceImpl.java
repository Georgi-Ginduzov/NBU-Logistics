package com.example.logistics.services;

import com.example.logistics.dtos.OfficeDto;
import com.example.logistics.models.Office;
import com.example.logistics.repositories.interfaces.OfficeRepository;
import com.example.logistics.services.interfaces.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public OfficeDto find(Long id) {
        Office office = officeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Office with ID " + id + " not found"));
        return mapToDto(office);
    }

    @Override
    public List<OfficeDto> findAll() {
        return officeRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OfficeDto add(OfficeDto officeDto) {
        Office office = mapToEntity(officeDto);
        Office savedOffice = officeRepository.save(office);
        return mapToDto(savedOffice);
    }

    @Override
    public OfficeDto update(Long id, OfficeDto officeDto) {
        Office office = officeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Office with ID " + id + " not found"));

        office.setLocation(officeDto.getLocation());
        office.setAddress(officeDto.getAddress());
        office.setPhone(officeDto.getPhone());

        Office updatedOffice = officeRepository.save(office);
        return mapToDto(updatedOffice);
    }

    @Override
    public void delete(Long id) {
        if (!officeRepository.existsById(id)) {
            throw new IllegalArgumentException("Office with ID " + id + " not found");
        }
        officeRepository.deleteById(id);
    }

    private OfficeDto mapToDto(Office office) {
        OfficeDto dto = new OfficeDto();
        dto.setId(office.getId());
        dto.setLocation(office.getLocation());
        dto.setAddress(office.getAddress());
        dto.setPhone(office.getPhone());
        return dto;
    }

    private Office mapToEntity(OfficeDto dto) {
        Office office = new Office();
        office.setLocation(dto.getLocation());
        office.setAddress(dto.getAddress());
        office.setPhone(dto.getPhone());
        return office;
    }
}
