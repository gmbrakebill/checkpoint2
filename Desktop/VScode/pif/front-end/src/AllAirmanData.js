import React from 'react';

function AllAirmanData(props)
{
    console.log(props);
    return(
        <div className = "airmen">
            <p>ID: {props.id}- {props.rank} {props.first_name} {props.last_name} {String(props.LOC)} {String(props.LOR)} {String(props.LOA)} {String(props.WAPS)} {props.last_review_date}{String(props.time_in_service)} {String(props.time_in_grade)} {String(props.epr_data)}</p>
        </div>
    )
}
export default AllAirmanData;