//package startspring.service.shop;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import startspring.dto.ResponseRequestDto;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ShopServiceImpl implements ShopService {
//
//    private final ShopRepository shopRepository;
//    private final QShopRepository qShopRepository;
//    private final ShopValidation shopValidation;
//
//    @Override
//    @Transactional
//    public ResponseRequestDto registerShop(RegisterShopDto registerShopDto) {
//        Shop shop = new Shop(registerShopDto);
//        shopRepository.save(shop);
//        return new ResponseRequestDto(true);
//    }
//
//    @Override
//    @Transactional
//    public ResponseRequestDto updateShop(Long shopId, UpdateShopDto updateShopDto) { // Transaction 시작
//        Shop existShop = shopValidation.validationCheck(shopId);
//
//        //qShopRepository.updateShop(existShop.getId(), updateShopDto);
//        existShop.updateShop(updateShopDto);
//        shopRepository.save(existShop);
//
//        return new ResponseRequestDto(true); // update commit
//    }
//
//    @Override
//    @Transactional
//    public ResponseRequestDto deleteShop(Long shopId) {
//        Shop existShop = shopValidation.validationCheck(shopId);
//        existShop.delete();
//        //shopRepository.save(existShop);
//        return new ResponseRequestDto(existShop.isDelete());
//
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public ShopDetail getShopId(Long shopId) {
//        Shop existShop = shopRepository.findById(shopId)
//                .orElseThrow(() -> new RuntimeException("shop 없잖아요!!!!!"));
//        return new ShopDetail(existShop);
//    }
//
//    @Override
//    public ResponseRequestDto getShopName(String shopName) {
//        List<Shop> existShop = shopRepository.findByShopNameContaining(shopName);
//        return new ResponseRequestDto(!existShop.isEmpty());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public ShopDetailResponse getShops() {
//        List<Shop> shops = shopRepository.findAll();
////        List<ShopDetail> result = new ArrayList<>();
////
////        for (Shop shop : shops) {
////            ShopDetail resultEl = new ShopDetail(shop);
////            result.add(resultEl);
////        }
//        List<ShopDetail> result = shops.stream()
//                .map(ShopDetail::new)
//                .collect(Collectors.toList());
//
//        return new ShopDetailResponse(result);
//    }
//}
//
