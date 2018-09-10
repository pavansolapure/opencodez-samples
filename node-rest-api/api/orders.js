import express from "express";

const router = express.Router();

router.get("/", (req, res, next) => {
    res.status(200).json({
        message:"Orders listed."
    });
});

router.get("/:orderId", (req, res, next) => {
    var oid = req.params.orderId;
    res.status(200).json({
        message:`You are at spcific orders page for id ${oid}.`,
        id: oid
    });
});

module.exports = router;