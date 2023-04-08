package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.PurchaseItem;
import repository.PurchaseItemRepo;

@Component
public class PurchaseItemService {

	 @Autowired
	 private PurchaseItemRepo purchaseItemDAO;

	 @Transactional
		public PurchaseItem getItemById(long id) {
		 return purchaseItemDAO.getItemById(id);
		
		}
		
	 @Transactional
		public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId) {
		 return purchaseItemDAO.getAllItemsByPurchaseId(purchaseId);
		}	
		
	 @Transactional
		public void updateItem(PurchaseItem item) {
		 	purchaseItemDAO.updateItem(item);
		}
		

	 @Transactional
		public void deleteItem(long id) {
		 	purchaseItemDAO.deleteAllItemsForPurchaseId(id);
		}

	 @Transactional
		public void deleteAllItemsForPurchaseId(long purchaseId) {
		 	purchaseItemDAO.deleteAllItemsForPurchaseId(purchaseId);
		}


	 
}

