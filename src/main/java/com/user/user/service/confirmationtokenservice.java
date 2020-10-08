// package com.user.user.service;

// import java.sql.Timestamp;
// import java.util.Calendar;

// import com.user.user.model.ConfirmationToken;
// import com.user.user.model.user;
// import com.user.user.repository.confirmtokenrepo;
// import com.user.user.repository.userrepo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class confirmationtokenservice {
    

//     @Autowired
//     confirmtokenrepo cr;

//     @Autowired
//     userrepo ur;

//     public void saveConfirmationToken(ConfirmationToken confirmationToken){
//         cr.save(confirmationToken);
//     }


//     public ConfirmationToken findByToken(String token){
//         return cr.findByToken(token);
//     }

//     public ConfirmationToken findByUser(user users){
//         return cr.findByUser(users);
//     }



//     //Calculating expiry data
//     private Timestamp calculateExpiryDate(int expiryDateInMinutes){
//         Calendar cal = Calendar.getInstance();
//         cal.add(Calendar.MINUTE, expiryDateInMinutes);
//         return new Timestamp(cal.getTime().getTime());

//     }
//     public void confirmUser(ConfirmationToken confirmationToken){
//             user user = confirmationToken.getUser();
//             user.setEnabled(true);

//             ur.save(user);

//             cr.deleteConfirmationTokenById(confirmationToken.getId());
//     }
// }
